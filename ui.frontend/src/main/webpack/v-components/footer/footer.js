import Vue from "vue";

import language from "./Footer";

const componentSelector = "#footer-vue";

const element = document.querySelector(componentSelector);

var vueGlobalObject = !element ?
    console.log("Can't find element with same selector:" + componentSelector) :
    new Vue({
        el: componentSelector,
        components: { "footer-language": language },
        template: componentSelector,
    });