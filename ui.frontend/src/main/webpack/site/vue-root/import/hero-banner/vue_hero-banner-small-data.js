import Vue from "vue";
let tagNameVue = "vue_hero-banner-small-data";

Vue.component(tagNameVue, require("@components/hero-banner/hero-banner-small/HeroBannerSmall"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "HeroBannerSmall" */ "@components/hero-banner/hero-banner-small/HeroBannerSmall")
);