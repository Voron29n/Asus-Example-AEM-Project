import Vue from "vue";
let tagNameVue = "vue_categories-nav-data";

Vue.component(tagNameVue, require("@components/proart/categories-nav/ProArtCategoriesNav"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ProArtCategoriesNav" */ "@components/proart/categories-nav/ProArtCategoriesNav")
);