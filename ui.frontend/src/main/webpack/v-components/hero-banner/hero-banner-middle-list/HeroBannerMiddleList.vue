<template>
    <v-hero-images-list :hero-banner-middle-list-data="heroBannerMiddleListData"></v-hero-images-list>
</template>

<script>
import HeroBannerMiddleList_ImagesListCmp from "./v-components/imagesList/HeroImagesList";

export default {
    components: {
        "v-hero-images-list": HeroBannerMiddleList_ImagesListCmp,
    },
    props: {
        heroBannerMiddleListItems: {
            type: String,
            required: true,
        },
    },
    computed: {
        heroBannerMiddleListData() {
            return JSON.parse(this.heroBannerMiddleListItems);
        },
    },
};
</script>
<style lang="scss" scoped>
@import "./v-style/banner_middle_list_default";
@import "./v-style/banner_middle_list_media";
</style>