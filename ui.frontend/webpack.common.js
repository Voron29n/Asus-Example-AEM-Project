"use strict";

const path = require("path");
const webpack = require("webpack");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const TSConfigPathsPlugin = require("tsconfig-paths-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const VueLoaderPlugin = require("vue-loader/lib/plugin");

const SOURCE_ROOT = __dirname + "/src/main/webpack";

module.exports = {
    resolve: {
        extensions: [".js", ".ts", ".vue", ".scss", ".json"],
        plugins: [
            new TSConfigPathsPlugin({
                configFile: "./tsconfig.json",
            }),
        ],
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
                path.join(__dirname, "src", "main", "webpack", "v-components", "v-mixin")
            ),
            "@common": path.resolve(
                path.join(__dirname, "src", "main", "webpack", "v-components", "v-common")
            ),
            "@plugin": path.resolve(
                path.join(__dirname, "src", "main", "webpack", "v-components", "v-plugin")
            ),
            'vue$': 'vue/dist/vue.esm.js'
        },
    },
    entry: {
        site: SOURCE_ROOT + "/site/main.ts",
    },
    output: {
        filename: 'js/[name].js',
        path: path.resolve(__dirname, "dist"),
        publicPath: '/bin/myDataSourcePoolServlet' + '/'
    },
    module: {
        rules: [{
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
            {
                test: /\.scss$/,
                loader: [
                    // "vue-style-loader",
                    MiniCssExtractPlugin.loader,
                    {
                        loader: 'css-loader',
                        options: {
                            url: false,
                            import: true,
                            sourceMap: true,
                        }
                    },
                    {
                        loader: 'sass-loader',
                        options: {
                            url: true,
                            // sourceMap: true
                        }
                    },
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
                    },
                ],
            },
        ],
    },
    plugins: [
        new VueLoaderPlugin(),
        new CleanWebpackPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),
        new MiniCssExtractPlugin({
            filename: 'css/[name].asus.css'
        }),
        new CopyWebpackPlugin([{
            from: path.resolve(__dirname, SOURCE_ROOT + "/resources"),
            to: "./clientlib-site/resources",
        }, ]),
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