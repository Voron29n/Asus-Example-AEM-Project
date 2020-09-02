"use strict";

const path = require("path");
const webpack = require("webpack");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const TSConfigPathsPlugin = require("tsconfig-paths-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const VueLoaderPlugin = require("vue-loader/lib/plugin");
const HtmlWebpackPlugin = require('html-webpack-plugin');

const SOURCE_ROOT = __dirname + "/src/main/webpack";

module.exports = {
    resolve: {
        extensions: [".js", ".ts", ".vue", ".scss", ".json"],
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
        filename: (chunkData) => {
            return chunkData.chunk.name === "dependencies" ?
                "clientlib-dependencies/[name].js" :
                "clientlib-site/[name].js";
        },
        path: path.resolve(__dirname, "dist"),
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
                test: /\.js$/,
                exclude: /node_modules/,
                loader: ["babel-loader"],
            },
            {
                test: /\.vue$/,
                use: {
                    loader: "vue-loader",
                    options: {
                        loaders: {
                            scss: [
                                "vue-style-loader"
                            ]
                        }
                    }
                }
            },
            {
                test: /\.scss$/,
                use: [
                    "vue-style-loader",
                    MiniCssExtractPlugin.loader,
                    {
                        loader: "css-loader",
                        options: {
                            url: false,
                        },
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
                        loader: "sass-loader",
                        options: {
                            url: false,
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
        ],
    },
    plugins: [
        new TSConfigPathsPlugin({
            configFile: "./tsconfig.json",
        }),
        new VueLoaderPlugin(),
        new CleanWebpackPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),
        // new MiniCssExtractPlugin({
        //     filename: "clientlib-site/[name].css",
        // }),
        new MiniCssExtractPlugin({
            filename: "[name].css",
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