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
export default {
    components: {
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

import (/* webpackChunkName: "HeroBannerMiddle" */ './v-style/_banner_middle_default.scss');
import (/* webpackChunkName: "HeroBannerMiddle" */ './v-style/_banner_middle_media.scss');
</script>