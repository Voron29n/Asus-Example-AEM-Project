<template>
    <div>
        <a :href="imageData.linkTo" :target="imageData.linkUrlTarget">
            <img :src="imageData.fileReference" alt />
        </a>
    </div>
</template>

<script>
export default {
    props: {
        imageData: Object
    }
};
</script>

<style lang="scss" scoped>
@import "../v-style/image_default";
@import "../v-style/image_media";
</style>