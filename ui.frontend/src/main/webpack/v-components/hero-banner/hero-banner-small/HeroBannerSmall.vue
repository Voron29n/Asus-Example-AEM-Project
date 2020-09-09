<template>
    <div class="banner-small-block">
        <div class="banner-small-inner">
            <div class="banner-small-wrap">
                <VueLink :link-data="linkData"></VueLink>
                <VueImage :image-data="imageData"></VueImage>
                <div class="banner-small-info">
                    <div :class="{'banner-small-info-wrap' : !isDesktopVersion}">
                        <VueTitle :title-data="titleData"></VueTitle>
                        <VueDescription :description-data="descriptionData"></VueDescription>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    components: {
        VueLink: () =>
            import(
                /* webpackChunkName: "HeroBannerSmall" */ "./v-components/link/Link"
            ),
        VueImage: () =>
            import(
                /* webpackChunkName: "HeroBannerSmall" */ "./v-components/image/Image"
            ),
        VueTitle: () =>
            import(
                /* webpackChunkName: "HeroBannerSmall" */ "./v-components/title/Title"
            ),
        VueDescription: () =>
            import(
                /* webpackChunkName: "HeroBannerSmall" */ "./v-components/description/Description"
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
        linkData() {
            return {
                heroLink: JSON.parse(this.$props.jsonOfLinkData),
            };
        },
        imageData() {
            return {
                fileReference: this.$props.fileReference,
            };
        },
        titleData() {
            return {
                heroTitle: this.$props.heroTitle,
            };
        },
        descriptionData() {
            return {
                heroDescription: this.$props.heroDescription,
            };
        },
    },
};

import (/* webpackChunkName: "HeroBannerSmall" */ './v-style/_banner_small_default.scss');
import (/* webpackChunkName: "HeroBannerSmall" */ './v-style/_banner_small_media.scss');
</script>