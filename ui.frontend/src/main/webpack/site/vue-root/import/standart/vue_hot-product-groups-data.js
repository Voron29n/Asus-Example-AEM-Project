import Vue from "vue";
let tagNameVue = "vue_hot-product-groups-data";

Vue.component(tagNameVue, require("@components/standart/hot-product-groups/HotProductGroups"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "HotProductGroups" */ "@components/standart/hot-product-groups/HotProductGroups")
);