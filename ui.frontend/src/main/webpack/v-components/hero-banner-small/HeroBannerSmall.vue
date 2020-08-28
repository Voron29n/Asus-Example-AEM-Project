<template>
    <div class="banner-small-block">
        <div class="banner-small-inner">
            <div class="banner-small-wrap">
                <v-link :link-data="linkData"></v-link>
                <v-image :image-data="imageData"></v-image>
                <div class="banner-small-info">
                    <div :class="{'banner-small-info-wrap' : !isDesktopVersion}">
                        <v-title :title-data="titleData"></v-title>
                        <v-description :description-data="descriptionData"></v-description>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import HeroBannerSmall_LinkCmp from "./v-components/link/Link";
import HeroBannerSmall_ImageCmp from "./v-components/image/Image";
import HeroBannerSmall_TitleCmp from "./v-components/title/Title";
import HeroBannerSmall_DescriptionCmp from "./v-components/description/Description";

import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    components: {
        "v-link": HeroBannerSmall_LinkCmp,
        "v-image": HeroBannerSmall_ImageCmp,
        "v-title": HeroBannerSmall_TitleCmp,
        "v-description": HeroBannerSmall_DescriptionCmp,
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
</script>
<style lang="scss">
@import "./v-style/banner_small_default";
@import "./v-style/banner_small_media";
</style>