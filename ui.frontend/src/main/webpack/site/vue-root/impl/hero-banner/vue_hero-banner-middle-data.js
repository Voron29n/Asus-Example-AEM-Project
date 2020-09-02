import Vue from "vue";

Vue.component("vue_hero-banner-middle-data", () =>
    import ( /* webpackChunkName: "HeroBannerMiddle" */ "@components/hero-banner/hero-banner-middle/HeroBannerMiddle")
);