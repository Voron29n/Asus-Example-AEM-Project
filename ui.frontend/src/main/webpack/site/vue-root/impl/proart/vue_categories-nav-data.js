import Vue from "vue";

Vue.component("vue_categories-nav-data", () =>
    import ( /* webpackChunkName: "ProArtCategoriesNav" */ "@components/proart/categories-nav/CategoriesNav")
);