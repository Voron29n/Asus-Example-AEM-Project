<template>
    <div>
        <a :href="imageData.linkTo" :target="imageData.linkUrlTarget">
            <img :src="imageData.fileReferenceDesktope" />
        </a>
    </div>
</template>

<script>
import constant from "@util/constant";

export default {
    data() {
        return {
            witchForMobileVersion: constant.heroBannerMiddle.widthForMobileVersion
        }
    },
    props: {
        imageData: Object,
    }
};
</script>

<style lang="scss" scoped>
@import "../v-style/image_default";
@import "../v-style/image_media";
</style>