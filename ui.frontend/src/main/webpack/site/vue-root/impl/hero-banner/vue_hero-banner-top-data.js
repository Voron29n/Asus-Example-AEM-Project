import Vue from "vue";

Vue.component("vue_hero-banner-top-data", () =>
    import ( /* webpackChunkName: "HeroBannerTop" */ "@components/hero-banner/hero-banner-top/HeroBannerTop")
);