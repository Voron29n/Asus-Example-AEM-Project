import Vue from "vue";
let tagNameVue = "vue_nav-info-page-data";

Vue.component(tagNameVue, require("@components/structure/nav-info-page/NavInfoPage"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "NavInfoPage" */ "@components/structure/nav-info-page/NavInfoPage")
);