<template>
    <div class="proart__hero_banner_top__title item-content">
        <div class="content-title text_bold text-gradient-gold">
            {{titleData.heroTitle}}
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