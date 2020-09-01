"use strict";

const path = require("path");
const webpack = require("webpack");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const TSConfigPathsPlugin = require("tsconfig-paths-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const VueLoaderPlugin = require("vue-loader/lib/plugin");
const DelWebpackPlugin = require("del-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");


const SOURCE_ROOT = __dirname + "/src/main/webpack";

module.exports = {
    resolve: {
        extensions: [".js", ".jsx", ".ts", ".vue", ".css", ".scss", ".json"],
        alias: {
            "@resources": path.resolve(
                path.join(__dirname, "src", "main", "webpack", "resources")
            ),
            "@components": path.resolve(
                path.join(__dirname, "src", "main", "webpack", "v-components")
            ),
            "@util": path.resolve(
                path.join(__dirname, "src", "main", "webpack", "v-components", "v-util")
            ),
            "@mixin": path.resolve(
                path.join(
                    __dirname,
                    "src",
                    "main",
                    "webpack",
                    "v-components",
                    "v-mixin"
                )
            ),
            "@common": path.resolve(
                path.join(
                    __dirname,
                    "src",
                    "main",
                    "webpack",
                    "v-components",
                    "v-common"
                )
            ),
            "@plugin": path.resolve(
                path.join(
                    __dirname,
                    "src",
                    "main",
                    "webpack",
                    "v-components",
                    "v-plugin"
                )
            ),
            vue$: "vue/dist/vue.esm.js",
            // 'vue$': 'vue/dist/vue.common.js'
            // 'vue$': 'vue/dist/vue.js'
        },
    },
    entry: {
        site: SOURCE_ROOT + "/site/main.ts",
    },
    output: {
        filename: (chunkData) => {
            return chunkData.chunk.name === "dependencies" ?
                "clientlib-dependencies/[name].js" :
                "clientlib-site/[name].js";
        },
        // chunkFilename: 'js/chunks/[name].[chunkhash].js',
        // chunkFilename: '[name][chunkhash].js',
        chunkFilename: "[name].js",
        path: path.resolve(__dirname, "dist"),
        // publicPath: '/',
        // publicPath: 'http://localhost:4502/',
    },
    module: {
        rules: [{
                test: /\.scss$/,
                loader: [
                    "vue-style-loader",
                    MiniCssExtractPlugin.loader,
                    {
                        loader: "css-loader",
                        options: {
                            url: false,
                        },
                    },
                    {
                        loader: "sass-loader",
                        options: {
                            // sourceMap: true,
                            url: false,
                        },
                    },
                    //     ExtractTextPlugin.extract({
                    //     fallback: "style-loader",
                    //     use: [
                    //         // "vue-style-loader",
                    //         // {
                    //         //     loader: "vue-style-loader",
                    //         // },
                    //         // MiniCssExtractPlugin.loader,
                    //         {
                    //             loader: 'css-loader',
                    //             options: {
                    //                 // If you are having trouble with urls not resolving add this setting.
                    //                 // See https://github.com/webpack-contrib/css-loader#url
                    //                 url: false,
                    //                 // sourceMap: true,
                    //                 // modules: true,
                    //             }
                    //         },
                    //         {
                    //             loader: 'sass-loader',
                    //             options: {
                    //                 url: false,
                    //                 // sourceMap: true
                    //             }
                    //         },
                    //         {
                    //             loader: "postcss-loader",
                    //             options: {
                    //                 plugins() {
                    //                     return [require("autoprefixer")];
                    //                 },
                    //                 // options: {},
                    //             },
                    //         },
                    //         {
                    //             loader: "resolve-url-loader",
                    //             // loader: 'resolve-url-loader?sourceMap',
                    //         },
                    //         {
                    //             loader: "webpack-import-glob-loader",
                    //             options: {
                    //                 url: false,
                    //             },
                    //         },
                    //     ]
                    // }),

                    {
                        loader: "postcss-loader",
                        options: {
                            plugins() {
                                return [require("autoprefixer")];
                            },
                        },
                    },
                    {
                        loader: "resolve-url-loader",
                    },
                    {
                        loader: "webpack-import-glob-loader",
                        options: {
                            url: false,
                        },
                    },
                ],
            },
            {
                test: /\.tsx?$/,
                exclude: /node_modules/,
                use: [{
                        options: {
                            eslintPath: require.resolve("eslint"),
                        },
                        loader: require.resolve("eslint-loader"),
                    },
                    {
                        loader: "ts-loader",
                    },
                    {
                        loader: "webpack-import-glob-loader",
                        options: {
                            url: false,
                        },
                    },
                ],
            },
            {
                // Transpiles ES6-8 into ES5
                test: /\.js$/,
                exclude: /node_modules/,
                exclude: (file) => /node_modules/.test(file) && !/\.vue\.js/.test(file),
            },
            {
                test: /\.vue$/,
                use: {
                    loader: "vue-loader",
                    options: {
                        loaders: {
                            scss: ["vue-style-loader"],
                        },
                    },
                },
            },

            // {
            //     test: /\.css$/,
            //     use: extractCSS.extract(['css-loader', 'postcss-loader'])
            // },
            // {
            //     test: /\.less$/i,
            //     use: extractLESS.extract(['css-loader', 'less-loader'])
            // },
        ],
    },
    plugins: [
        new VueLoaderPlugin(),
        new TSConfigPathsPlugin({
            configFile: "./tsconfig.json",
        }),
        new CleanWebpackPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),
        new HtmlWebpackPlugin(),
        new MiniCssExtractPlugin({
            filename: "clientlib-[name]/[name].css",
        }),
        // new ExtractTextPlugin("styles.css"),
        new ExtractTextPlugin({
            filename: (getPath) => {
                return getPath("css/[name].css").replace("css/js", "css");
            },
            allChunks: true,
        }),
        // extractCSS,
        // extractSCSS,
        // extractLESS,
        new CopyWebpackPlugin([{
            from: path.resolve(__dirname, SOURCE_ROOT + "/resources"),
            to: "./clientlib-site/resources",
        }, ]),
        new DelWebpackPlugin({
            include: ["/js/chunks/*.js"],
            info: true,
            keepGeneratedAssets: true,
            allowExternal: false,
        }),
    ],
    stats: {
        assetsSort: "chunks",
        builtAt: true,
        children: false,
        chunkGroups: true,
        chunkOrigins: true,
        colors: false,
        errors: true,
        errorDetails: true,
        env: true,
        modules: false,
        performance: true,
        providedExports: false,
        source: false,
        warnings: true,
    },
};