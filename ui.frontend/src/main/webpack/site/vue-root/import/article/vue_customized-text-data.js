import Vue from "vue";
let tagNameVue = "vue_customized-text-data";

Vue.component(tagNameVue, require("@components/article/customized-text/CustomizedText"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "CustomizedText" */ "@components/article/customized-text/CustomizedText")
);