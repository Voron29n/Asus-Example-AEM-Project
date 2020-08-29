export default {
    install(Vue, options) {
        Vue.prototype.$_POST = async function (url, body) {
            let response = await fetch(url,
                {
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
    }
};
