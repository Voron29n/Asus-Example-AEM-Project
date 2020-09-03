import Vue from "vue";
let tagNameVue = "vue_products-nav-data";

Vue.component(tagNameVue, require("@components/proart/products-nav/ProArtProductsNav"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ProArtProductsNav" */ "@components/proart/products-nav/ProArtProductsNav")
);