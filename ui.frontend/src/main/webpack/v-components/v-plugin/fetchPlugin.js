export default {
    install(Vue, options) {
        Vue.prototype.$_POST = async function(url, body) {
            let response = await fetch(url, {
                method: "POST",
                cache: "no-cache",
                headers: {
                    Accept: "*/*",
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(body),
            });
            return response;
        };

        Vue.prototype.$_GET_MODEL = async function(resourcePath, selector, extension) {

            const defaultSelector = `.model`;
            const defaultExtensions = `.json`;

            let requestSelector = selector !== undefined ? selector : defaultSelector;
            let requestExtension = extension !== undefined ? extension : defaultExtensions;

            let urlValue = resourcePath.concat(requestSelector, requestExtension);

            // let requestUrl = new URL(urlValue);

            let response = await fetch(urlValue, {
                method: "GET",
                cache: "no-cache",
                headers: {
                    Accept: "*/*",
                    "Content-Type": "application/json",
                },
            });
            return response;
        };

        Vue.prototype.$_GET = async function(url, params) {
            let requestUrl = new URL(url);

            /* EXAMPLE PARAMS */
            /* var params = { lat: 35.696233, long: 139.570431 }; // or:
            var params = [
                ["lat", "35.696233"],
                ["long", "139.570431"],
            ]; */
            if (params !== undefined) {
                requestUrl.search = new URLSearchParams(params).toString();
            }

            let response = await fetch(requestUrl, {
                method: "GET",
                cache: "no-cache",
                headers: {
                    Accept: "*/*",
                    "Content-Type": "application/json",
                },
            });
            return response;
        };
    },
};