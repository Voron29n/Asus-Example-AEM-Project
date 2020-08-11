<template>
    <div class="cmp_article_image_text-description">
        <sly>{{descriptionData.imageTextDescription}} @ context="html"
                <img :class="imageClass" :src="imageData.fileReference" alt=""/>
        </sly>
    </div>
</template>

<script>

export default {
    props: {
        descriptionData: Object,
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
@import "./description_default";
@import "./description_media";
</style>