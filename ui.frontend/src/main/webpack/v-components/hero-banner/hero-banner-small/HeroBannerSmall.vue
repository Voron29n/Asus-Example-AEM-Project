<template>
        <div class="banner-small-block">
            <div class="banner-small-inner">
                <HeroSmall
                    :hero-small-data="heroSmallData"
                ></HeroSmall>
            </div>
        </div>
</template>

<script>
import HeroSmall from "./v-components/HeroSmall";

export default {
    components: {
        HeroSmall: () =>
            import(
                /* webpackChunkName: "HeroBannerSmall" */ "./v-components/HeroSmall"
            ),
    },
    props: {
        jsonOfLinkData: {
            type: String,
            required: false,
        },
        fileReference: {
            type: String,
            required: false,
        },
        heroTitle: {
            type: String,
            required: false,
        },
        heroDescription: {
            type: String,
            required: false,
        },
    },
    computed: {
        heroSmallData() {
            return {
                heroLink: JSON.parse(this.$props.jsonOfLinkData),
                fileReference: this.$props.fileReference,
                heroTitle: this.$props.heroTitle,
                heroDescription: this.$props.heroDescription,
            };
        },
    },
};

import (/* webpackChunkName: "HeroBannerSmall" */ './v-style/_banner_small_default.scss');
import (/* webpackChunkName: "HeroBannerSmall" */ './v-style/_banner_small_media.scss');
</script>