import Vue from "vue";
let tagNameVue = "vue_hero-banner-middle-data";

Vue.component(tagNameVue, require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "HeroBannerMiddle" */ "@components/hero-banner/hero-banner-middle/HeroBannerMiddle")
);
// Vue.component('vue_hero-banner-middle-data', (resolve) => {
//     import ( /* webpackChunkName: "HeroBannerMiddle" */ "@components/hero-banner/hero-banner-middle/HeroBannerMiddle")
//     .then((HeroBannerMiddle) => {
//         resolve(HeroBannerMiddle.default);
//     });
// });