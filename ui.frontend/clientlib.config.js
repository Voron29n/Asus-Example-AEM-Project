/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2020 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
const path = require('path');

const BUILD_DIR = path.join(__dirname, 'dist');
const CLIENTLIB_DIR = path.join(
    __dirname,
    '..',
    'ui.apps',
    'src',
    'main',
    'content',
    'jcr_root',
    'apps',
    'asus',
    'clientlibs'
);

const libsBaseConfig = {
    allowProxy: true,
    serializationFormat: 'xml',
    cssProcessor: ['default:none', 'min:none'],
    jsProcessor: ['default:none', 'min:none']
};

// Config for `aem-clientlib-generator`
module.exports = {
    context: BUILD_DIR,
    clientLibRoot: CLIENTLIB_DIR,
    libs: [{
            ...libsBaseConfig,
            name: 'clientlib-dependencies',
            categories: ['asus.dependencies'],
            assets: {
                // Copy entrypoint scripts and stylesheets into the respective ClientLib
                // directories
                js: {
                    cwd: 'js',
                    files: ['*.js'],
                    flatten: false,
                    ignore: ['site.js']
                },
                css: {
                    cwd: 'css',
                    files: ['*.css'],
                    flatten: false,
                    ignore: ['site.asus.css']
                },
            }
        },
        {
            ...libsBaseConfig,
            name: 'clientlib-site',
            categories: ['asus.site'],
            dependencies: ['asus.dependencies'],
            assets: {
                // Copy entrypoint scripts and stylesheets into the respective ClientLib
                // directories
                js: {
                    cwd: 'js',
                    files: ['site.*'],
                    flatten: true,
                },

                // default config
                css: {
                    cwd: 'css',
                    files: ['site.*'],
                    flatten: true,
                },

                // Copy all other files into the `resources` ClientLib directory
                resources: {
                    cwd: 'clientlib-site/resources',
                    files: ['**/*.*'],
                    flatten: false,
                    ignore: ['**/*.js', '**/*.css']
                },

            }
        }
    ]
};