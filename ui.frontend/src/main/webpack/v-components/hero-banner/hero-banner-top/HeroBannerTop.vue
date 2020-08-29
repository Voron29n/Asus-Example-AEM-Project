<template>
    <div>
        <v-images :images-data="imagesData"></v-images>
    </div>
</template>

<script>
import HeroBannerTop_ImagesCmp from "./v-components/images/Images";

export default {
    components: {
        "v-images": HeroBannerTop_ImagesCmp,
    },
    props: {
        heroItems: {
            type: String,
            required: false,
        },
    },
    computed: {
        imagesData() {
            return {
                heroItems: JSON.parse(this.$props.heroItems),
            };
        },
    },
};
</script>

<style lang="scss">
@import "./v-style/hero_banner_top_default";
@import "./v-style/hero_banner_top_media";
</style>