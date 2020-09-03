import Vue from "vue";
let tagNameVue = "vue_proart_hero-banner-top-data";

Vue.component(tagNameVue, require("@components/proart/hero-banner-top/ProArtHeroBannerTop"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ProArtHeroBannerTop" */ "@components/proart/hero-banner-top/ProArtHeroBannerTop")
);