<template>
    <VueHeroImagesList :hero-banner-middle-list-data="heroBannerMiddleListData"></VueHeroImagesList>
</template>

<script>
export default {
    components: {
        VueHeroImagesList: () =>
            import(
                /* webpackChunkName: "HeroBannerMiddleList" */ "./v-components/imagesList/HeroImagesList"
            ),
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
