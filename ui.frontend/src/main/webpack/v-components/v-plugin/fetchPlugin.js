export default {
    install(Vue, options) {
        Vue.prototype.$_POST = async function(url, body) {
            let response = await fetch(url, {
                method: 'POST',
                cache: 'no-cache',
                headers: {
                    'Accept': '*/*',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body)
            });
            return response;
        };

        Vue.prototype.$_GET_MODEL = async function(resourcePath) {
            let response = await fetch(resourcePath + ".model.json", {
                method: 'GET',
                cache: 'no-cache',
                headers: {
                    'Accept': '*/*',
                    'Content-Type': 'application/json',
                }
            });
            return response;
        };
    }
};
