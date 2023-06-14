const { merge } = require('webpack-merge');
const common = require('./webpack.common.js');
const path = require('path');

module.exports = merge(common, {
    mode: 'development',
    devtool: 'eval-source-map',
    devServer: {
        static: [{
            directory: path.join(__dirname, '../src/assets/js'),
            watch: true,
        }, {
            directory: path.join(__dirname, '../src/assets/css'),
            watch: true,
        }, {
            directory: path.join(__dirname, '../src/views'),
            watch: true,
        }],
        compress: true,
        port: 3001,
        proxy: {
            '/message': {
                target: 'http://localhost:3000',
                secure: false,
                changeOrigin: true
            }
        }
    },
    module: {
        rules: [
            {
                test: /\.(scss|css)$/,
                use: [
                    'style-loader',
                    'css-loader',
                    'sass-loader'
                ],
            },
        ],
    }
});