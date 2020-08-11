<template>
    <div class="cmp_article_image_text-image">
        <img :class="imageClass" :src="imageData.fileReference" alt=""/>
    </div>
</template>

<script>

export default {
    props: {
        imageData: Object,
    },

    computed: {
        imageClass() {
             if (this.$props.imageData.imageIsRightSide) {
            return 'span3 rightimg'
        } else {
            return 'span3 leftimg'
        }
        },
    },

};

</script>

<style lang="scss">
@import "./image_default";
@import "./image_media";
</style>