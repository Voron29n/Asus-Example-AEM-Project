<template>
    <div class="banner-small-img">
        <img :src="imageData.fileReference" />
    </div>
</template>

<script>

export default {
    props: {
        imageData: Object,
    },
};

</script>

<style lang="scss" scoped>
@import "./image_default";
@import "./image_media";
</style>