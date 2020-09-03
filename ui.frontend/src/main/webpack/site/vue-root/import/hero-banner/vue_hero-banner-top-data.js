import Vue from "vue";
let tagNameVue = "vue_hero-banner-top-data";

Vue.component(tagNameVue, require("@components/hero-banner/hero-banner-top/HeroBannerTop"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "HeroBannerTop" */ "@components/hero-banner/hero-banner-top/HeroBannerTop")
);