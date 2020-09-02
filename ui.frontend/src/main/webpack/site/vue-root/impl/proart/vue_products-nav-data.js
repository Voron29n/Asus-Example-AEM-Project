import Vue from "vue";

Vue.component("vue_products-nav-data", () =>
    import ( /* webpackChunkName: "ProArtProductsNav" */ "@components/proart/products-nav/ProductsNav")
);