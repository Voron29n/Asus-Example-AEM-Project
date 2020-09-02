import Vue from "vue";

Vue.component("vue-nav-info-page-data", () =>
    import ( /* webpackChunkName: "NavInfoPage" */ "@components/structure/nav-info-page/NavInfoPage")
);