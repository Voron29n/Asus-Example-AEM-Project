import store from "@js/store/store";

export default {
    store,
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
        Vue.prototype.$_POST_Auth = async function (url, body) {
            let response = await fetch(url,
                {
                    method: 'POST',
                    cache: 'no-cache',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer_${store.state.token}`
                    },
                    body: JSON.stringify(body)
                });
            return response;
        };
    }
};