import Vue from "vue";

import HeroBannerMiddle from "./HeroBannerMiddle.vue";

Vue.config.devtools = true;

var hero = new Vue({
    el: "#hero-banner-middle-vue",
    components: { "hero-banner-middle": HeroBannerMiddle },
    template: "#hero-banner-middle-vue"
});
