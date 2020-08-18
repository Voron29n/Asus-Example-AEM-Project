<template>
    <div>
        <h1 class="page-title double-border-bottom">{{titleData.title}}</h1>
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