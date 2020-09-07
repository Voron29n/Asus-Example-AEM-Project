import Vue from "vue";
export default async function() {
    return await Vue.component('hero-banner-middle-data', require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle").default);
};