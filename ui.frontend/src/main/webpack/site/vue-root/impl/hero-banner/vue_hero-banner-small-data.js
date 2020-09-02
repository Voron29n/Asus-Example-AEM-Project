import Vue from "vue";

Vue.component("vue_hero-banner-small-data", () =>
    import ( /* webpackChunkName: "HeroBannerSmall" */ "@components/hero-banner/hero-banner-small/HeroBannerSmall")
);