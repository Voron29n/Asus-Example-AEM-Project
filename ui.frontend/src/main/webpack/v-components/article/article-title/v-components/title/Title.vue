<template>
    <div class="cmp_article-title">
        <h2 class="item-title"></h2>
        <h2>{{titleData.title}}</h2>
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