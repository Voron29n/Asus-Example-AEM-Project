<template>
    <div class="af-banner-middle">
        <div class="banner-middle-block">
            <div class="banner-middle-inner">
                <VueHeroMiddle :hero-middle-data="heroMiddleData"></VueHeroMiddle>
            </div>
        </div>
    </div>
</template>

<script>
// import Vue from "vue";
// import heroBannerMiddle from './HeroBannerMiddle.vue';
// Vue.component('hero-banner-middle-data', heroBannerMiddle);

// Vue.component('hero-banner-middle-data', require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle").default);
// Vue.component('hero-banner-middle-data', (resolve) => {
//     import ( /* webpackChunkName: "HeroBannerMiddle" */ "@components/hero-banner/hero-banner-middle/HeroBannerMiddle")
//     .then((HeroBannerMiddle) => {
//         resolve(HeroBannerMiddle.default);
//     });
// });

export default {
    name: "hero-banner-middle-data",
    components: {
        "hero-banner-middle-data": () => import( /* webpackChunkName: "HeroBannerMiddle" */ './HeroBannerMiddle.vue').then(m => m.default),
        VueHeroMiddle: () =>
            import(
                /* webpackChunkName: "HeroBannerMiddle" */ "./v-components/HeroMiddle"
            ).then(m => m.default),
    },
    props: {
        linkTo: {
            type: String,
            required: false,
        },
        linkUrlTarget: {
            type: String,
            required: false,
        },
        fileReferenceMobile: {
            type: String,
            required: false,
        },
        fileReferenceDesktop: {
            type: String,
            required: false,
        },
    },
    computed: {
        heroMiddleData() {
            return {
                linkTo: this.$props.linkTo,
                linkUrlTarget: this.$props.linkUrlTarget,
                fileReferenceMobile: this.$props.fileReferenceMobile,
                fileReferenceDesktop: this.$props.fileReferenceDesktop,
            };
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./v-style/banner_middle_default";
@import "./v-style/banner_middle_media";
</style>