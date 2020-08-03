<template>
    <div class="banner-wrap">
        <a class="af-link-block" :href="imageData.linkTo" :target="imageData.linkUrlTarget"></a>
        <div class="banner-img">
            <img :src="imageSrc" />
        </div>
    </div>
</template>

<script>
import constant from "@util/v-constant";

export default {
    data() {
        return {
            imageSrc: "",
            witchForMobileVersion:
                constant.heroBannerMiddle.widthForMobileVersion,
        };
    },
    props: {
        imageData: Object,
    },
    mounted() {
        this.resize();
        window.addEventListener("resize", this.resize);
    },
    beforeDestroy() {
        window.removeEventListener("resize", this.resize);
    },
    methods: {
        resize() {
            this.$data.imageSrc =
                window.innerWidth > this.witchForMobileVersion
                    ? this.$props.imageData.fileReferenceDesktope
                    : this.$props.imageData.fileReferenceMobile;
        },
    },
};
</script>

<style lang="scss">
@import "../v-style/image_default";
</style>