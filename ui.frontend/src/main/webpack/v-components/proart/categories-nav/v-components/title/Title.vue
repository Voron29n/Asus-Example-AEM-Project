<template>
    <div class="wd_content text_animation large_text-center medium_text-center small_text-left wd_content-main">
        <div class="content_slogan text-gradient-gold">
            <span class="slogan-text">{{titleData.categoriesTitle}}</span>
        </div>
    </div>
</template>

<script>

export default {
    props: {
        titleData: Object,
    },
    
};
</script>

<style lang="scss">
@import "./title_default";
@import "./title_media";
</style>