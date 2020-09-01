<template>
    <div>
        <div>Hero Banner Middle List Images</div>
        <ul class="banner-hero-list">
            <div class="banner-hero-list-wrap"
                 :style="translateImg"
            >
                <li
                    v-for="(heroMiddleItem, index) in heroBannerMiddleListData"
                    :key="heroMiddleItem.fileReferenceDesktop"
                    :class="{'active': index == activeImageId }"
                >
                    <v-hero-img :hero-item="heroMiddleItem"></v-hero-img>
                </li>
            </div>
            <v-slick-dots
                v-if="isNeedShowSlickDots"
                :items-data="heroBannerMiddleListData"
                :active-item-id="activeImageId"
                @change-slick-dots="slickDots"
            ></v-slick-dots>
        </ul>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

import HeroMiddleListImage from "../heroImage/HeroMiddleListImage";

import SlickDots from "@common/slick-dots/SlickDots";

export default {
    mixins: [adapt],
    components: {
        "v-hero-img": HeroMiddleListImage,
        "v-slick-dots": SlickDots,
    },
    props: {
        heroBannerMiddleListData: {
            type: Array,
            required: true,
        },
    },
    data() {
        return {
            activeImageId: 0,
        };
    },
    methods: {
        slickDots() {
            console.log("change");
        },
    },
    computed: {
        isNeedShowSlickDots() {
            return (
                !this.isDesktopVersion &&
                this.heroBannerMiddleListData.length > 1
            );
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./banner_images_list_default";
// @import "./v-style/banner_middle_list_images_media";
</style>