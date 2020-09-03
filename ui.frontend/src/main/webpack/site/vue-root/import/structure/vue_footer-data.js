import Vue from "vue";
let tagNameVue = "vue_footer-data";

Vue.component(tagNameVue, require("@components/structure/footer/Footer"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "Footer" */ "@components/structure/footer/Footer")
);