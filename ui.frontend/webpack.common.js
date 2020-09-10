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
        extensions: [".js", ".ts", ".vue", ".css", ".scss", ".json", ".eot", ".svg", ".ttf", ".woff"],
        alias: {
            "@resources": path.resolve(
                path.join(__dirname, "src", "main", "webpack", "site", "resources")
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
        filename: 'apps/asus/clientlibs/clientlib-vue/js/[name].js',
        path: path.resolve(__dirname, "dist"),
        publicPath: '/',
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
                        options: {
                            appendTsSuffixTo: [/\.vue$/],
                            transpileOnly: true
                        },
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
                test: /\.(scss)$/,
                resolve: { extensions: [".scss"], },
                loader: [
                    // "vue-style-loader",
                    {
                        loader: MiniCssExtractPlugin.loader,
                    },
                    {
                        loader: 'css-loader',
                        options: {
                            sourceMap: true,
                            importLoaders: 1,
                            url: false
                        }
                    },
                    {
                        loader: `postcss-loader`,
                        options: {
                            plugins() {
                                return [require("autoprefixer")];
                            },
                        },
                    },
                    'resolve-url-loader?sourceMap',
                    'sass-loader?sourceMap',
                    {
                        loader: "webpack-import-glob-loader",
                    },
                ],
            },
            {
                test: /\.css$/,
                loader: [
                    'style-loader',
                    {
                        loader: MiniCssExtractPlugin.loader,
                    },
                    {
                        loader: 'css-loader',
                        options: {
                            sourceMap: true,
                            importLoaders: 1,
                            url: true
                        }
                    },
                ],
            },
            {
                test: /\.(ico|jpg|jpeg|png|gif|webp)(\?.*)?$/,
                use: {
                    loader: 'file-loader',
                    options: {
                        name: '[name].[ext]',
                        outputPath: 'apps/asus/clientlibs/clientlib-vue/resources/images'
                    }
                }
            },
            {
                test: /\.(eot|otf|ttf|woff|woff2|svg)(\?.*)?$/,
                use: {
                    loader: 'file-loader',
                    options: {
                        name: '[name].[ext]',
                        outputPath: 'apps/asus/clientlibs/clientlib-vue/resources/fonts',
                    },
                },
            },
            {
                test: /\.(mp4|webm|wav|mp3|m4a|aac|oga)(\?.*)?$/,
                use: {
                    loader: 'url-loader',
                    options: {
                        limit: 100000,
                        name: '[name].[ext]',
                        outputPath: 'urls/'
                    }
                }
            },
        ],
    },
    plugins: [
        new VueLoaderPlugin(),
        new TSConfigPathsPlugin({
            configFile: "./tsconfig.json",
        }),
        new CleanWebpackPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),
        new MiniCssExtractPlugin({
            filename: 'apps/asus/clientlibs/clientlib-vue/css/[name].css',
        }),
        // new CopyWebpackPlugin([{
        //     from: path.resolve(__dirname, SOURCE_ROOT + "/site/resources"),
        //     to: "./resources",
        // }, ]),
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