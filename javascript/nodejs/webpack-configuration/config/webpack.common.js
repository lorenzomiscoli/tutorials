var path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');

module.exports = {
    module: {
        rules: [{
            test: /\.js$/,
            exclude: /node_modules/,
            use: ['babel-loader'],
          },
          {
            test: /\.(png|svg|jpg|gif|ico)$/,
            type: 'asset/resource',
            generator: {
              filename: './assets/images/[name][ext]'
            }
          }
          ]
    },
    entry: {
        'index': path.resolve(__dirname, '../src/assets/js/index.js')
    },
    output: {
        filename: "assets/js/[name].bundle.js",
        path: path.resolve(__dirname, '../dist'),
        publicPath: '/',
        clean: true
      },
    plugins: [
        new webpack.ProvidePlugin({
            $: "jquery",
            jQuery: "jquery"
        }),
        new HtmlWebpackPlugin({
            template: 'src/views/index.html',
            inject: true,
            chunks: ['index'],
            filename: 'index.html'
        })
    ]
};