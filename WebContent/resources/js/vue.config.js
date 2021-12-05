// vue.config.js
module.exports = {
    // ...
    devServer: {
        open: process.platform === 'darwin',
        Host: '0.0.0.0',
        port: 8080, // CHANGE YOUR PORT HERE!
        https: false,
        hotOnly: false,
    },
    // ...
}