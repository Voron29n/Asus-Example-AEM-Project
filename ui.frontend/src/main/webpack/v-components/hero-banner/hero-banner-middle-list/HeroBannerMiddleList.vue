<template>
    <div>
        <VueHeroImagesList v-if="isCycle" :hero-banner-middle-list-data="heroBannerMiddleListData"></VueHeroImagesList>
        <VueHeroImagesListCycle v-else :hero-banner-middle-list-data="heroBannerMiddleListData"></VueHeroImagesListCycle>
    </div>
</template>

<script>
export default {
    components: {
        VueHeroImagesList: () =>
            import(
                /* webpackChunkName: "HeroBannerMiddleList" */ "./v-components/imagesList/HeroImagesList"
            ),
        VueHeroImagesListCycle: () =>
            import(
                /* webpackChunkName: "VueHeroImagesListCycle" */ "./v-components/imagesListCycle/HeroImagesList"
            ),
    },
    props: {
        heroBannerMiddleListItems: {
            type: String,
            required: true,
        },
        isCycle: {
            type: Boolean,
            required: false,
            default: false
        },
    },
    methods: {
        customCreateArray(propsArray) {
            let firstElem = propsArray.shift();
            propsArray.unshift(propsArray.pop());
            propsArray.push(firstElem);
            return propsArray;
        },
    },
    computed: {
        heroBannerMiddleListData() {
            let array = JSON.parse(this.heroBannerMiddleListItems);
            return this.isCycle ? this.customCreateArray(array) : array;
        },
    },
};
</script>
