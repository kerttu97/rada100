module.exports = {
    // Change build paths to make them Maven compatible
    // see https://cli.vuejs.org/config/
    runtimeCompiler: true,
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8088',
                ws: true,
                changeOrigin: true
            }
        }
    },
    outputDir: 'target/dist',
    assetsDir: 'static',
    transpileDependencies: ['vuex-persist']
};
