<template>
    <div>
        <VueImages :images-data="imagesData"></VueImages>
    </div>
</template>

<script>
export default {
    components: {
        VueImages: () =>
            import(
                /* webpackChunkName: "HeroBannerTop" */ "./v-components/images/Images"
            ),
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