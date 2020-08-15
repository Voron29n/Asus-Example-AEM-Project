<template>
        <div class="banner-small-block">
            <div class="banner-small-inner">
                <v-hero-small
                    :hero-small-data="heroSmallData"
                ></v-hero-small>
            </div>
        </div>
</template>

<script>
import HeroSmall from "./v-components/HeroSmall";

export default {
    components: {
        "v-hero-small": HeroSmall,
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
</script>
<style lang="scss">
@import "./v-style/banner_small_default";
@import "./v-style/banner_small_media";
</style>